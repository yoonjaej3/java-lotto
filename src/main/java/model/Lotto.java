package model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> lotto = new ArrayList<>();

    public Lotto() {
    }

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return this.lotto;
    }

    public int matchCount(List<Integer> winLotto) {
        List<Integer> copyList = new ArrayList<>(lotto);

        int equalNum = (int) copyList.stream()
                .filter(winLotto::contains)
                .count();

        return equalNum;
    }

}
