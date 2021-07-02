/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizNQuestion;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class QuizQuestionDTO implements Serializable{
    private int No;
    private int questionNo;
    private int quizID;
    private int questionID;
    private String content;
    private String explanation;
    private String level;
    private String mediaLink;

    public QuizQuestionDTO() {
    }

    public QuizQuestionDTO(int No, int questionNo, int quizID, int questionID, String content, String explanation, String level, String mediaLink) {
        this.No = No;
        this.questionNo = questionNo;
        this.quizID = quizID;
        this.questionID = questionID;
        this.content = content;
        this.explanation = explanation;
        this.level = level;
        this.mediaLink = mediaLink;
    }

    public void setNo(int No) {
        this.No = No;
    }

    public int getNo() {
        return No;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public int getQuizID() {
        return quizID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public String getContent() {
        return content;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getLevel() {
        return level;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setExplanation(String explaination) {
        this.explanation = explaination;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }
    
    
}
