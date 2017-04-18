package com.tianlai.mocktest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * Created by tianlai on 17-4-17.
 */
public class PresenterTest {

    @Mock
    Repo repo;

    @InjectMocks
    Presenter presenter;


    @Before
    public void setUp() throws Exception {
        repo = Mockito.mock(Repo.class);

        presenter = new Presenter(repo);
    }


    @Test
    public void getData() throws Exception {

        String name = "xiaoming";

        int id = 123;

        presenter.getData(id, name);

        Mockito.verify(repo).optData(id, name);

        name = null;
        id = 0;

        presenter.getData(id, name);

        Mockito.verify(repo).optError(id, name);


    }

    @After
    public void tearDown() throws Exception {
        presenter = null;
        repo = null;
    }


}