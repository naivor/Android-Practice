package com.tianlai.mocktest;

/**
 * Created by tianlai on 17-4-17.
 */

public class Presenter {
    private Repo repo;

    public Presenter(Repo repo) {
        this.repo = repo;
    }


    public void getData(int id, String name) {

        if (id > 0 && name != null) {
            repo.optData(id, name);
        } else {
            repo.optError(id, name);
        }
    }

}
