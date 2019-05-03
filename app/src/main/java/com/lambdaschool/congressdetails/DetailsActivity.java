package com.lambdaschool.congressdetails;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lambdaschool.congressdataapiaccess.CongressDao;
import com.lambdaschool.congressdataapiaccess.CongresspersonDetails;
import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Intent intent = getIntent();
        String congressPersonId = intent.getStringExtra("congress_person_id");

        CongressPersonDetailsViewModel congressPersonDetailsViewModel = ViewModelProviders.of(this).get(CongressPersonDetailsViewModel.class);
        congressPersonDetailsViewModel.getCongressPersonDetails(congressPersonId).observe(this, new Observer<CongresspersonDetails>() {
            @Override
            public void onChanged(CongresspersonDetails congresspersonDetails) {
                ((ImageView) findViewById(R.id.details_image_view)).setImageBitmap(CongressDao.getImage(congresspersonDetails.getMemberId()));
                String formattedDisplay = String.format("%s %s %s %s\n" +
                                "Gender: %s\n" +
                                "Current Party: %s\n" +
                                "Most Recent Vote: %s\n" +
                                "In Office? %s\n" +
                                "DOB: %s\n" +
                                "Roles: %s\n" +
                                "URL: %s\n" +
                                "Times Topics URL: %s\n" +
                                "Times Tag: %s\n" +
                                "Government Track ID: %s\n" +
                                "CSPAN ID: %s\n" +
                                "VoteSmart ID: %s\n" +
                                "ICPSR ID: %s\n" +
                                "Twitter Account: %s\n" +
                                "Facebook Account: %s\n" +
                                "YouTube Account: %s\n" +
                                "CRP ID: %s\n" +
                                "Google Entity ID: %s\n" +
                                "RSS URL: %s\n" +
                                "Last Updated: %s\n",
                        congresspersonDetails.getFirstName(),
                        congresspersonDetails.getMiddleName(),
                        congresspersonDetails.getLastName(),
                        congresspersonDetails.getSuffix(),
                        congresspersonDetails.getGender(),
                        congresspersonDetails.getCurrentParty(),
                        congresspersonDetails.getMostRecentVote(),
                        congresspersonDetails.isInOffice(),
                        congresspersonDetails.getDateOfBirth(),
                        congresspersonDetails.getRoles().toString(),
                        congresspersonDetails.getUrl(),
                        congresspersonDetails.getTimesTopicsUrl(),
                        congresspersonDetails.getTimesTag(),
                        congresspersonDetails.getGovtrackId(),
                        congresspersonDetails.getCspanId(),
                        congresspersonDetails.getVotesmartId(),
                        congresspersonDetails.getIcpsrId(),
                        congresspersonDetails.getTwitterAccount(),
                        congresspersonDetails.getFacebookAccount(),
                        congresspersonDetails.getYoutubeAccount(),
                        congresspersonDetails.getCrpId(),
                        congresspersonDetails.getGoogleEntityId(),
                        congresspersonDetails.getRssUrl(),
                        congresspersonDetails.getLastUpdated());

                ((TextView) findViewById(R.id.details_text_view)).setText(formattedDisplay);
            }
        });
    }
}
