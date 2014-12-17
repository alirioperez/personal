package com.seabware.framework.domain.model;


import javax.persistence.*;

/**
 * Base class for all entities
 */
@MappedSuperclass
public abstract class AbstractEntity
{
    private Long id;
    protected Long version;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId()
    {
        return id;
    }

    @Version
    public Long getVersion()
    {
        return version;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }
}
