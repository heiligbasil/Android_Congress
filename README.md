# Android_Congress



## Instructions

### Part 1 - Clone Repo

1. Click the green clone or download button on the repo.
2. Copy the provided URL
3. Open a git bash console in the directory where you want your project to be.
4. Clone the repo into your workspace

### Part 2 - Import the Project into Android Studio

1. Open Android Studio
2. Import the cloned project
   a. With an open project, go to File->New->Import
   b. With all projects closed, click Import Project

### Part 3 - Create the List Activity using the MVVM Model

1. Create the layout for an activity that will list the display name for all returned congresspeople.  
> You can see the data provided for all congresspeople in this query in the API documentation (https://projects.propublica.org/api-docs/congress-api/members/#lists-of-members)
2. Write a CongressPerson repository class that will wrap data from the provided library in a `MutableLiveData` object and return it.  
> Use `ArrayList<CongresspersonOverview> rawData = CongressDao.getAllMembers();` to get overview details from the library.  
3. Write a `ViewModel`class that returns a singleton `LiveData` object.
> Remember, a singleton class doesn't have a public constructor. Intead, it has a getter that checks if the object has been instantiated, if it hasn't it builds the object and returns it. If it has, it returns the object.
4. In your `Activity` class, attach your viewmodel to the view by using `viewModel = ViewModelProviders.of(this).get(MyViewModel.class)`  
5. Call the `observe(Context, Oobserver)` method. In the observer, write what the app should do each time the data is updated (ie update the UI).
> You'll want to build a display name for each congressperson combining things like First and Last Name, party and state.  
> Add the congress person's ID to the `Tag` field of the `View` object so you can retreive it when the view is clicked.
> If this takes more than a few lines of code, do it in a separate method.
> You'll need to use `runOnUiThread` to perform the final process of attaching the new `View` to the UI.
6. Be sure to thoroughly test this activity.

### Part 4 - Create Details View Layout and Link the two together

1. Create a layout for an Activity that will display details for a selected congress person.
> You can see the data provided for each congressperson in this query in the API documentation (https://projects.propublica.org/api-docs/congress-api/members/#get-a-specific-member)
2. In your list Activity, build an `onClickListener` that will retrieve the `Tag` from the view and attach it to an `Intent` which launches your new activity.
3. Test your `Intent`.

### Part 5 - Build a MVVM structure for your details activity

1. Repeat steps 2 - 6 of part 4 for your new activity.

## Submit

Submit your project to your PM by sending them a link to your repository on GitHub via Slack DM (Direct Message).
