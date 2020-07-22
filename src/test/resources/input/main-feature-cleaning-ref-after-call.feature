Feature: Main Feature

Background:
  * configure report = { showLog: true, showAllSteps: true }

Scenario Outline: Main feature
  When def param = { "input" : "<test>" }
  Then def freemarker_utils = Java.type('com.example.demo.FreemarkerUtils')
  And freemarker_utils.addFreeMarkerUtils(param);

  # do whatever I want to do with freemarker here
  # adding another Java object
  Then def test_obj = Java.type('com.example.demo.TestObject')
  And def obj = new test_obj()
  And obj.setName('test')
  And set param $.obj = obj

  And print param

  And call read('this:called-feature.feature') param
  And freemarker_utils.cleanUpFreeMarkerUuid(param);


  When url 'http://unreachable-host.com/test'
  Given path '/unit-test/bank-account/open'
  And request { "param": "will fail anyways" }
  And header Accept = 'application/json'
  And header Content-Type = 'application/json'
  When method post
  Then status 200

Examples:
  | test |
  | data1 |
  | data2 |