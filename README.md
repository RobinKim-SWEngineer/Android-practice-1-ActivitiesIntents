# Android-practice-1-ActivitiesIntents
Use of intents for data exchange between activities

![Alt Text](https://github.com/RobinKim-SWEngineer/Images-for-document/blob/master/ActivitiesIntents.gif)

Through intent we can start an activity from another activity and send, receieve data between them. Activities are pushed onto **back stack** and latest one takes user focus. They follow **LIFO** ( last in first out ) order. 

## Related methods
- When we expect some data back from the activity that we are going to start, we must request the activity via  :
`startActivityForResult(Intent intent, int requestCode)`  
Here *int requestCode* works as a flag to identity the request upon receiving the data back.

- Data can be attached in the calling activity through `intent.putExtra(String key, String value)` and acquired in requested activity through `intent.getStringExtra(String key)` in case the data type is String. Here the data is interchanged in the form of **dictionary** and key is used to get the value out of it.

- Upon `finish()` in the activity that was requested by the calling activity, the result data is available in the calling activity through :
`onActivityResult(int requestCode, int resultCode, Intent data)`

- Before `finish()` the requested activity, we set the resultCode and data (Intent) to send back in `setResult(int resultCode, Intent intent)`

For more detail implementation of **Intent** for each step, please refer to the attached example.
