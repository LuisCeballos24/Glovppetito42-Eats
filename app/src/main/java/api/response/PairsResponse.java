package gg.rubit.api.response;

public class PairsResponse {

    private int questionId;
    private int answerId;
    private int pairsOrder;
    private String question;
    private String answer;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getPairsOrder() {
        return pairsOrder;
    }

    public void setPairsOrder(int pairsOrder) {
        this.pairsOrder = pairsOrder;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
