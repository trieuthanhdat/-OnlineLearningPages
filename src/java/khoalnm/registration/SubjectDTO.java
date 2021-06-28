/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoalnm.registration;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class SubjectDTO implements Serializable{
    private int subjectID;
    private int subjectCategoryID;
    private String title;
    private int numberOfLesson;
    private String tagLine;
    private String thumbnail;
    private String owner;
    private String description;
    private String briefInfo;
    private boolean status;

    public SubjectDTO() {
    }

    public SubjectDTO(int subjectID, int subjectCategoryID, String title, int numberOfLesson, String tagLine, String thumbnail, String owner, String description, String briefInfo, boolean status) {
        this.subjectID = subjectID;
        this.subjectCategoryID = subjectCategoryID;
        this.title = title;
        this.numberOfLesson = numberOfLesson;
        this.tagLine = tagLine;
        this.thumbnail = thumbnail;
        this.owner = owner;
        this.description = description;
        this.briefInfo = briefInfo;
        this.status = status;
    }

    /**
     * @return the subjectID
     */
    public int getSubjectID() {
        return subjectID;
    }

    /**
     * @param subjectID the subjectID to set
     */
    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    /**
     * @return the subjectCategoryID
     */
    public int getSubjectCategoryID() {
        return subjectCategoryID;
    }

    /**
     * @param subjectCategoryID the subjectCategoryID to set
     */
    public void setSubjectCategoryID(int subjectCategoryID) {
        this.subjectCategoryID = subjectCategoryID;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the numberOfLesson
     */
    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    /**
     * @param numberOfLesson the numberOfLesson to set
     */
    public void setNumberOfLesson(int numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
    }

    /**
     * @return the tagLine
     */
    public String getTagLine() {
        return tagLine;
    }

    /**
     * @param tagLine the tagLine to set
     */
    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    /**
     * @return the thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail the thumbnail to set
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the briefInfo
     */
    public String getBriefInfo() {
        return briefInfo;
    }

    /**
     * @param briefInfo the briefInfo to set
     */
    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

   
    
}
