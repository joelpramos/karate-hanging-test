Feature: Main Feature

Background:
  * configure report = { showLog: true, showAllSteps: true }

Scenario: Main feature
  When def param = { "input" : "sample>" }
  Then def freemarker_utils = Java.type('com.example.demo.FreemarkerUtils')
  And freemarker_utils.addFreeMarkerUtils(param);
  #And freemarker_utils.cleanUpFreeMarkerUuid(param);

  And call read('this:called-feature.feature') param


  When url 'http://unreachable-host.com/test'
  Given path '/unit-test/bank-account/open'
  And request { "param": "will fail anyways" }
  And header Accept = 'application/json'
  And header Content-Type = 'application/json'
  When method post
  Then status 200
