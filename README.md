TimeLapse
=======
A small library that transform a time lapse between now and a Date object into a human-readable string

Download
--------

[ ![Download](https://api.bintray.com/packages/deimian86/TimeLapse/time-lapse/images/download.svg) ](https://bintray.com/deimian86/TimeLapse/time-lapse/_latestVersion)

Add the dependency to your module's build.gradle:
```groovy
compile 'com.deimian86:time-lapse:0.0.5'
```

Usage
----

In code:
```groovy
TextView txtView = view.findViewById(R.id.textView);
txtView.setText(new TimeLapse().getLapse(context, date, Locale.ENGLISH));
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
