package com.lambdaschool.congressdetails;

import android.arch.lifecycle.MutableLiveData;

import com.lambdaschool.congressdataapiaccess.CongressDao;
import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

import java.util.ArrayList;

public class CongressPersonOverviewRepository {
    public MutableLiveData<ArrayList<CongresspersonOverview>> getTheGoods() {
        MutableLiveData<ArrayList<CongresspersonOverview>> mutableLiveDataList = new MutableLiveData<>();
        mutableLiveDataList.setValue(CongressDao.getAllMembers());
        return mutableLiveDataList;
    }
}
