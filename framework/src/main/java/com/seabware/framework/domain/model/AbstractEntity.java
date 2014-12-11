package com.seabware.framework.domain.model;


import javax.persistence.Version;

public abstract class AbstractEntity
{
    @Version
    protected Long version;

    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }
}
