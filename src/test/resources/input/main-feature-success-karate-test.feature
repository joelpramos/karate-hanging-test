Feature: Main Feature

Background:
  * configure report = { showLog: true, showAllSteps: true }

Scenario Outline: Main feature
  When def param = { "input" : "<test>" }
  Then def freemarker_utils = Java.type('com.example.demo.FreemarkerUtils')
  And freemarker_utils.addFreeMarkerUtils(param);
  #And freemarker_utils.cleanUpFreeMarkerUuid(param);

  And call read('this:called-feature.feature') param


  Then assert 1 == 1

Examples:
  | test |
  | data1 |
  | data2 |