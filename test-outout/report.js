$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/GS-2397/Documents/FileBeat UI Automation/src/main/java/Features/FileBeat.feature");
formatter.feature({
  "line": 1,
  "name": "Perform Automation on Filebeat",
  "description": "",
  "id": "perform-automation-on-filebeat",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Extract Filebeat and Run FileBeat",
  "description": "",
  "id": "perform-automation-on-filebeat;extract-filebeat-and-run-filebeat",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user is already Download  FileBeat Zip",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Perform Extract ZIP File",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Read Filebeat.yaml and make changes",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Execute Filebeat.sh file and run Filebeat.yaml file",
  "keyword": "Then "
});
formatter.match({
  "location": "filebeat.user_is_already_Download_FileBeat_Zip()"
});
formatter.result({
  "duration": 401723400,
  "status": "passed"
});
formatter.match({
  "location": "filebeat.perform_Extract_ZIP_File()"
});
formatter.result({
  "duration": 1932972100,
  "status": "passed"
});
formatter.match({
  "location": "filebeat.read_Filebeat_yaml_and_make_changes()"
});
formatter.result({
  "duration": 4054715300,
  "status": "passed"
});
formatter.match({
  "location": "filebeat.execute_Filebeat_sh_file_and_run_Filebeat_yaml_file()"
});
formatter.result({
  "duration": 10035019600,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Perform Automation UI Filebeat",
  "description": "",
  "id": "perform-automation-on-filebeat;perform-automation-ui-filebeat",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "user is already on Kibana page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Index Created",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Verify Index Created and Click on Create Index",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Search Log on Kibana",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "search Invalid log on Kibana gives Negative Results",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 16,
      "value": "#  Scenario: Perform Clean-up For Filebeat"
    }
  ],
  "line": 17,
  "name": "when user is on already created Index and Index Pattern and user is on that Page",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "delete index and Index Pattern",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "Delete FileBeat Directory",
  "keyword": "Then "
});
formatter.match({
  "location": "filebeat.user_is_already_on_Kibana_page()"
});
formatter.result({
  "duration": 10954940800,
  "status": "passed"
});
formatter.match({
  "location": "filebeat.index_Created()"
});
formatter.result({
  "duration": 1052609700,
  "status": "passed"
});
formatter.match({
  "location": "filebeat.verify_Index_Created_and_Click_on_Create_Index()"
});
formatter.result({
  "duration": 4194222500,
  "status": "passed"
});
formatter.match({
  "location": "filebeat.search_Log_on_Kibana()"
});
formatter.result({
  "duration": 746669500,
  "status": "passed"
});
formatter.match({
  "location": "filebeat.search_Invalid_log_on_Kibana_gives_Negative_Results()"
});
formatter.result({
  "duration": 1679568200,
  "status": "passed"
});
formatter.match({
  "location": "filebeat.when_user_is_on_already_created_Index_and_Index_Pattern_and_user_is_on_that_Page()"
});
formatter.result({
  "duration": 20767800,
  "status": "passed"
});
formatter.match({
  "location": "filebeat.delete_index_and_Index_Pattern()"
});
formatter.result({
  "duration": 7528997400,
  "status": "passed"
});
formatter.match({
  "location": "filebeat.delete_FileBeat_Directory()"
});
formatter.result({
  "duration": 197981700,
  "status": "passed"
});
});