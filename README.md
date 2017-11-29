# StudentApp

This is simply following along with a course from Udemy, which covers
Serenity and how it can be used with RestAssured, as it is integrated
with Serenity.

[Serenity](http://www.thucydides.info/#/) is a BDD (Behavior Driven Development) tool, which makes
it easier to write scripts similarly to Cucumber, but covers more ground.

It produces some really nice reports with detailed and customizable
information, which are really helpful for the team and for the business value.

I have plans in the future to also integrate this with [Taurus](https://gettaurus.org/) which is
from [BlazeMeter](https://www.blazemeter.com/mobile_version/index.php).

They have some pretty cool tools to use, and Taurus is open source. It
is really useful for Performance Testing, where you can run your test cases
and in the terminal of your IDE, be able to see the performance as well in
a similar fashion to JMeter.

You can call on Test Scripts with Taurus, so you won't have to recreate
anything with JMeter, you simply need to create a file which would call
on the Test Scripts. And Taurus can easily be integrated with tools such
as Jenkins.

However that is for the future, but the possibilities are endless.

Here is an example of a file using Taurus:

```
- concurrency: 20
  ramp-up: 60m
  hold-for: 60m
  scenario: purchase-flight-jmeter-test

- concurrency: 30
  ramp-up: 30m
  hold-for: 90m
  scenario: find-lots-of-flights-jmeter-test

- concurrency: 25
  ramp-up: 40m
  hold-for: 80m
  scenario: find-simple-flight-jmeter-test

- concurrency: 15
  ramp-up: 120m
  hold-for: 10m
  scenario: verify-week-destination-jmeter-test

scenarios:
  purchase-flight-jmeter-test:
      script: ../jmeter/FlightPurchaseTest.jmx
  find-lots-of-flights-jmeter-test:
      script: ../jmeter/FindLotsOfFlightsTest.jmx
  find-simple-flight-jmeter-test:
      script: ../jmeter/FindSimpleFlightTest.jmx
  verify-week-destination-jmeter-test:
      script: ../jmeter/VerifyWeekDestinationTest.jmx
```
