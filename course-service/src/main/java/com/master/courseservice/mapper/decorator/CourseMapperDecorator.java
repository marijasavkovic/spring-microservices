package com.master.courseservice.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.master.courseservice.domain.CourseEntity;
import com.master.courseservice.domain.LecturerEntity;
import com.master.courseservice.domain.TeachingTypeEntity;
import com.master.courseservice.domain.ThematicUnitEntity;
import com.master.courseservice.mapper.CourseMapper;
import com.master.courseservice.model.course.Course;
import com.master.courseservice.model.course.CourseCmd;
import com.master.courseservice.model.lecturer.Lecturer;
import com.master.courseservice.model.lecturer.LecturerCmd;
import com.master.courseservice.model.thematicunit.ThematicUnit;
import com.master.courseservice.model.thematicunit.ThematicUnitCmd;
import com.master.courseservice.repository.TeachingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CourseMapperDecorator implements CourseMapper {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeachingTypeRepository teachingTypeRepository;

    @Override
    public List<Course> mapToModelList(final List<CourseEntity> courseEntities) {
        if (courseEntities == null) {
            return null;
        }

        List<Course> list = new ArrayList<>(courseEntities.size());
        for (CourseEntity courseEntity : courseEntities) {
            list.add(mapToModel(courseEntity));
        }

        return list;
    }

    @Override
    public CourseEntity mapToEntity(final CourseCmd model) {
        CourseEntity courseEntity = courseMapper.mapToEntity(model);

        mapLecturerList(model.getLecturerList(), courseEntity);
        mapThematicUnits(model.getThematicUnitsList(), courseEntity);
        return courseEntity;
    }

    @Override
    public LecturerEntity lecturerCmdToLecturerEntity(final LecturerCmd lecturerCmd) {
        LecturerEntity lecturerEntity = courseMapper.lecturerCmdToLecturerEntity(lecturerCmd);

        if (lecturerCmd.getTeachingTypeId() != null) {
            TeachingTypeEntity teachingTypeEntity = teachingTypeRepository
                .findById(lecturerCmd.getTeachingTypeId())
                .orElseThrow(RuntimeException::new);
            lecturerEntity.setTeachingType(teachingTypeEntity);
        }

        return lecturerEntity;
    }

    @Override
    public void updateEntityFromModel(final CourseCmd model, final CourseEntity entity) {
        if (model == null) {
            return;
        }
        courseMapper.updateEntityFromModel(model, entity);

        updateLecturerList(model.getLecturerList(), entity);
        mapThematicUnits(model.getThematicUnitsList(), entity);

    }

    private void mapLecturerList(List<LecturerCmd> lecturers, CourseEntity entity) {
        if (entity.getLecturerList() != null) {
            entity.getLecturerList().clear();
        }
        if (lecturers != null && !lecturers.isEmpty()) {
            for (LecturerCmd lecturerCmd : lecturers) {
                LecturerEntity lecturerEntity = lecturerCmdToLecturerEntity(lecturerCmd);
                lecturerEntity.setCourse(entity);
                entity.addLecturer(lecturerEntity);
            }
        }
    }

    private void updateLecturerList(List<LecturerCmd> lecturers, CourseEntity entity) {
        List<LecturerEntity> lecturerEntities = new ArrayList<>();
        for (LecturerCmd lecturerCmd : lecturers) {
            lecturerEntities.add(lecturerCmdToLecturerEntity(lecturerCmd));
        }
        entity.getLecturerList().removeIf((LecturerEntity lecturerEntity) -> {
            return !lecturerEntities.contains(lecturerEntity);
        });
        for (LecturerEntity lecturerEntity : lecturerEntities) {
            entity.addLecturer(lecturerEntity);
        }
    }

    private void mapThematicUnits(List<ThematicUnitCmd> list, CourseEntity entity) {
        if (entity.getThematicUnitsList() != null) {
            entity.getThematicUnitsList().clear();
        }
        if (list != null && !list.isEmpty()) {
            for (ThematicUnitCmd thematicUnitCmd : list) {
                if(entity.getThematicUnitsList()!=null && !entity.getThematicUnitsList().stream()
                    .map(ThematicUnitEntity::getSerialNumber).anyMatch(thematicUnitCmd.getSerialNumber()::equalsIgnoreCase)) {
                    entity.getThematicUnitsList().add(cmdToEntityThematicUnit(list, thematicUnitCmd, entity));
                }
            }
        }
    }

    private ThematicUnitEntity cmdToEntityThematicUnit(
        final List<ThematicUnitCmd> list,
        final ThematicUnitCmd thematicUnitCmd,
        CourseEntity entity)
    {

        ThematicUnitEntity thematicUnitEntity = thematicUnitCmdToThematicUnitEntity(thematicUnitCmd);
        thematicUnitEntity.setCourse(entity);
        if (thematicUnitCmd.getParentThematicUnitSerialNumber() != null && !thematicUnitCmd
            .getParentThematicUnitSerialNumber()
            .isEmpty()) {

            ThematicUnitEntity parent = findParentTemathicUnit(
                list, entity, thematicUnitCmd.getParentThematicUnitSerialNumber());
            thematicUnitEntity.setParentThematicUnit(parent);
        }
        return thematicUnitEntity;
    }

    private ThematicUnitEntity findParentTemathicUnit(
        final List<ThematicUnitCmd> list,
        final CourseEntity entity,
        final String parentThematicUnitSerialNumber)
    {

        for (ThematicUnitEntity thematicUnitEntity : entity.getThematicUnitsList()) {
            if (thematicUnitEntity.getSerialNumber().equalsIgnoreCase(parentThematicUnitSerialNumber)) {
                return thematicUnitEntity;
            }
        }

        for (ThematicUnitCmd thematicUnitCmd : list) {
            if (thematicUnitCmd.getSerialNumber().equalsIgnoreCase(parentThematicUnitSerialNumber)) {
                ThematicUnitEntity parent = cmdToEntityThematicUnit(list, thematicUnitCmd, entity);
                entity.getThematicUnitsList().add(parent);
                return parent;
            }
        }
        return null;

    }

    @Override
    public CourseCmd courseToCourseCmd(final Course course) {
        CourseCmd courseCmd = courseMapper.courseToCourseCmd(course);

        courseCmd.setLecturerList(new ArrayList<>());
        courseCmd.setThematicUnitsList(new ArrayList<>());
        for (Lecturer lecturer : course.getLecturerList()){
            courseCmd.getLecturerList().add(lecturerToLecturerCmd(lecturer));
        }
        for (ThematicUnit thematicUnit : course.getThematicUnitsList()){
            System.out.println(thematicUnit.getParentThematicUnit());
            courseCmd.getThematicUnitsList().add(thematicUnitToThematicUnitCmd(thematicUnit));
        }
        return courseCmd;
    }

    private LecturerCmd lecturerToLecturerCmd(final Lecturer lecturer) {
        LecturerCmd lecturerCmd = new LecturerCmd();
        lecturerCmd.setId(lecturer.getId());
        if(lecturer.getTeachingType()!=null)lecturerCmd.setTeachingTypeId(lecturer.getTeachingType().getId());
        return lecturerCmd;
    }

    private ThematicUnitCmd thematicUnitToThematicUnitCmd(final ThematicUnit thematicUnit) {
        ThematicUnitCmd thematicUnitCmd = new ThematicUnitCmd();
        thematicUnitCmd.setId(thematicUnit.getId());
        thematicUnitCmd.setName(thematicUnit.getName());
        thematicUnitCmd.setDescription(thematicUnit.getDescription());
        thematicUnitCmd.setSerialNumber(thematicUnit.getSerialNumber());
        thematicUnitCmd.setParentThematicUnitSerialNumber(thematicUnit.getParentThematicUnit()!=null ? thematicUnit.getParentThematicUnit().getSerialNumber():null);
        return thematicUnitCmd;
    }
}
