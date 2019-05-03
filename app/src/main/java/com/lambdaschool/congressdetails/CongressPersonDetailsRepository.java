package com.lambdaschool.congressdetails;

import android.arch.lifecycle.MutableLiveData;

import com.lambdaschool.congressdataapiaccess.CongressDao;
import com.lambdaschool.congressdataapiaccess.CongresspersonDetails;

public class CongressPersonDetailsRepository {
    public MutableLiveData<CongresspersonDetails> getTheGoods(String congressPersonId) {
        MutableLiveData<CongresspersonDetails> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(CongressDao.getMemberDetails(congressPersonId));
        return mutableLiveData;
    }
}
