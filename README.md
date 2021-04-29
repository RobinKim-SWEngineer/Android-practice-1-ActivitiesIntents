# Android-practice-1-ActivitiesIntents
Use of intents for data exchange between activities

![Alt Text](https://github.com/RobinKim-SWEngineer/Images-for-document/blob/master/ActivitiesIntents.gif)

Through intent we can start an activity from another activity and send, receieve data between them. Activities are pushed onto **back stack** and latest one takes user focus. They follow **LIFO** ( last in first out ) order. 

Activity goes through a **lifecyle** from creation to destroy with corresponding call back methods being executed. Some congifuration changes ( rotating phone etc. ) makes the activity restart, and in such case user would lose the current data in the activity. To prevent that we need to save the the **activity instance state** and restore them upon restart of activity.

## Related methods
- When we expect some data back from the activity that we are going to start, we must request the activity via  :
`startActivityForResult(Intent intent, int requestCode)`  
Here *int requestCode* works as a flag to identity the request upon receiving the data back.

- Data can be attached in the calling activity through `intent.putExtra(String key, String value)` and acquired in requested activity through `intent.getStringExtra(String key)` in case the data type is String. Here the data is interchanged in the form of **dictionary** (`Bundle`) and key is used to get the value out of it.

- Upon `finish()` in the activity that was requested by the calling activity, the result data is available in the calling activity through :
`onActivityResult(int requestCode, int resultCode, Intent data)`

- Before `finish()` the requested activity, we set the resultCode and data (Intent) to send back in `setResult(int resultCode, Intent intent)`. Here the intent is new intent, which is *different from* the intent that started new (the requested) activity. 

- Lifecyle **callback methods** can be overriden to change application default behavior. In the example we can check all the Logs for each callback method call.

- `onSaveInstanceState(Bundle outState)` is called by the system before the activity is destroyed to save the states. We can preserve the current state like `outState.putInt(String key, int value)`. They are saved in `savedInstanceState` as ``Bundle`` objects.

    > However, `onSaveInstanceState(Bundle outState)` **will not be called** when user navigates back to previous activity **using back (arrow) button**. In such case `SharedPreferences` interface should be used to preserve the instance state.

- When restoring the saved states, it is recommended practice to do it onCreate() method. We provide the key and get the state back like `savedInstanceState.getInt(String key)`

For more detail implementation of **Intent** for each step and **restoring instance state**, please refer to the attached example.
