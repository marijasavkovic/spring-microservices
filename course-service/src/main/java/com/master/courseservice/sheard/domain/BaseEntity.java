package com.master.courseservice.sheard.domain;

import java.io.Serializable;

public abstract class BaseEntity<T extends Serializable> {

    public abstract T getId();

    public abstract void setId(T id);

}
