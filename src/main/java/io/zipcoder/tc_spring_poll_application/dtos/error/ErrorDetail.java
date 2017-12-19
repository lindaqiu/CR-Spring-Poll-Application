package io.zipcoder.tc_spring_poll_application.dtos.error;
/*
Spring provides some built-in exception handling and error response, but we'll customize it a bit here.
Create an ErrorDetail class in a new io.zipcoder.tc_spring_poll_application.dto.error package
 to hold relevant information any time an error occurs.

Fields (Don't forget to provide getters and setters):

String title: a brief title of the error condition, eg: "Validation Failure" or "Internal Server Error"
int status: the HTTP status code for the current request; redundant but useful for client-side error handling

String detail: A short, human-readable description of the error that may be presented to a user

long timeStamp: the time in milliseconds when the error occurred

String developerMessage: detailed information such as exception class name or a stack trace useful for developers to debug


 */
public class ErrorDetail {

private String title;
private String detail;
private long timeStamp;
private String developerMessage;

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
