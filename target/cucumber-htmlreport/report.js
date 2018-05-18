$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AgBiePageSmokeTest.feature");
formatter.feature({
  "line": 2,
  "name": "Visit page and do Smoke tests",
  "description": "",
  "id": "visit-page-and-do-smoke-tests",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Visit Page and do Smoke Test",
  "description": "",
  "id": "visit-page-and-do-smoke-tests;visit-page-and-do-smoke-test",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@All"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Go to URL",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I do search",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "should be able to visit different tabs",
  "keyword": "Then "
});
formatter.match({
  "location": "AgBiePageSmokeTest.go_to_URL()"
});
formatter.result({
  "duration": 23714464915,
  "status": "passed"
});
formatter.match({
  "location": "AgBiePageSmokeTest.i_do_search()"
});
formatter.result({
  "duration": 2656474505,
  "status": "passed"
});
formatter.match({
  "location": "AgBiePageSmokeTest.should_be_able_to_visit_different_tabs()"
});
formatter.result({
  "duration": 3330492368,
  "status": "passed"
});
});