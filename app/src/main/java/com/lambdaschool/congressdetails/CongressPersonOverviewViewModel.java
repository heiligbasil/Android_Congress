package com.lambdaschool.congressdetails;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

import java.util.ArrayList;

public class CongressPersonOverviewViewModel extends ViewModel {
    private MutableLiveData<ArrayList<CongresspersonOverview>> mutableLiveDataList;
    private CongressPersonOverviewRepository congressPersonOverviewRepository;

    public LiveData<ArrayList<CongresspersonOverview>> getCongressPersonOverviewList() {
        if (mutableLiveDataList==null) {
            stuffTheGoods();
        }
        return mutableLiveDataList;
    }

    private void stuffTheGoods() {
        congressPersonOverviewRepository=new CongressPersonOverviewRepository();
        mutableLiveDataList = congressPersonOverviewRepository.getTheGoods();
    }
}
