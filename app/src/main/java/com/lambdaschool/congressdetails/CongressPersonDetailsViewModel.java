package com.lambdaschool.congressdetails;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.lambdaschool.congressdataapiaccess.CongresspersonDetails;

public class CongressPersonDetailsViewModel extends ViewModel {
    private MutableLiveData<CongresspersonDetails> mutableLiveData;
    private CongressPersonDetailsRepository congressPersonDetailsRepository;

    public LiveData<CongresspersonDetails> getCongressPersonDetails(String congressPersonId) {
        if (mutableLiveData == null) {
            stuffTheGoods(congressPersonId);
        }
        return mutableLiveData;
    }

    private void stuffTheGoods(String congressPersonId) {
        congressPersonDetailsRepository = new CongressPersonDetailsRepository();
        mutableLiveData = congressPersonDetailsRepository.getTheGoods(congressPersonId);
    }
}
