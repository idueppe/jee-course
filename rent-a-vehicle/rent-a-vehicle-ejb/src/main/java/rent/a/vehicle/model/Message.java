package rent.a.vehicle.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Message implements Identifiable {
    
    // künstlicher (technischer) Schlüssel
    @Id
    @GeneratedValue
    private Long id;
    
    // fachlicher Schlüssel
    private Long messageNumber;
    
    private String text;
    
    private String author;
    
    @OneToOne(fetch=FetchType.LAZY)
    private Attachment attachment;
    
    @Version
    private long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(Long messageNumber) {
        this.messageNumber = messageNumber;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

}
