TimeLapse
=======
A small library that calculates and transform the time elapsed between now and a Date object into a human-readable string to use wherever you want. 

![TimeLapse screenshot1](https://raw.githubusercontent.com/deimian86/TimeLapse/master/screenshot1.png)
![TimeLapse screenshot2](https://raw.githubusercontent.com/deimian86/TimeLapse/master/screenshot2.png)

Download
--------

[ ![Download](https://api.bintray.com/packages/deimian86/TimeLapse/time-lapse/images/download.svg) ](https://bintray.com/deimian86/TimeLapse/time-lapse/_latestVersion)

Add the dependency to your module's build.gradle:
```groovy
compile 'com.deimian86:time-lapse:0.0.6'
```

Usage
----

```groovy
TimeLapse.with(Context context)
   .date(Date date)
   .getLapse()
```

In code:
```groovy
TextView txtView = findViewById(R.id.txtView);
txtView.setText(TimeLapse.with(mContext).date(mDate).getLapse());
```

License
--------

    Copyright 2017 deimian86

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
