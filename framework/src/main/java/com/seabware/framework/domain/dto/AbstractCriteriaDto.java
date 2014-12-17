package com.seabware.framework.domain.dto;

import java.io.Serializable;

/**
 * Base class for Criteria. Used as a request including criteria for searches.
 */
public abstract class AbstractCriteriaDto implements Serializable
{
    private static final long serialVersionUID = 5932020104343068606L;

    public boolean isNonEmpty(Object object)
    {
        boolean nonEmpty = true;

        if (object == null)
        {
            nonEmpty = false;
        }
        else if (object instanceof String)
        {
            nonEmpty = !((String) object).isEmpty();
        }

        return nonEmpty;
    }

    public boolean isTrue(Boolean theBigBoolean)
    {
        return theBigBoolean != null && theBigBoolean.booleanValue();
    }

}