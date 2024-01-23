package it.epicode.be.entities;

import it.epicode.be.enums.ConcertType;

import javax.persistence.*;


@Entity
@Table(name = "concerts")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "event_date")
    private String eventDate;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private ConcertType concertType;

    @Column(name = "max_participants")
    private int maxParticipants;

    public Concert() {

    }

    public Concert(String title, String eventDate, String description, ConcertType concertType, int maxParticipants) {
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.concertType = concertType;
        this.maxParticipants = maxParticipants;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ConcertType getEventType() {
        return concertType;
    }

    public void setEventType(ConcertType concertType) {
        this.concertType = concertType;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }





}
