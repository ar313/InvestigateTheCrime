package crimeapp.flatrocktech.com.investigatethecrime;


class AnswerHelper {

    static boolean checkAnswer(String suspectName) {

        switch (suspectName) {
            case "The Maid":
                return false;
            case "The Gardner":
                return false;
            case "The Electrician":
                return true;
            case "The Cook":
                return false;
            default:
                return false;
        }
    }
}
