package io.zipcoder.tc_spring_poll_application.dtos;
//Data Transfer Object
//Because we don’t have any domain objects that can directly help generate
// this resource representation, we implement two Data Transfer Objects or
// DTOs—OptionCount and VoteResult
public class OptionCount {
    private Long optionId;
    private int count;

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}