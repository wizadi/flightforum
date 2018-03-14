package ro.wizadi.flightforum.modules.common.domain.entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    protected U createdBy;
    protected U updatedBy;

    protected Date createdAt;
    protected Date updatedAt;

    @LastModifiedBy
    public U getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(U updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    @CreatedBy
    public U getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(U createdBy)
    {
        this.createdBy = createdBy;
    }

    @CreatedDate
    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    @LastModifiedDate
    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }
}
