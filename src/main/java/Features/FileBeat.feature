Feature: Perform Automation on Filebeat

  Scenario:Extract Filebeat and Run FileBeat
    Given user is already Download  FileBeat Zip
    Then Perform Extract ZIP File
    Then Read Filebeat.yaml and make changes
    Then Execute Filebeat.sh file and run Filebeat.yaml file

  Scenario: Perform Automation UI Filebeat
    Given user is already on Kibana page
    Then Index Created
    Then Verify Index Created and Click on Create Index
    Then Search Log on Kibana
    Then search Invalid log on Kibana gives Negative Results

#  Scenario: Perform Clean-up For Filebeat
    Given when user is on already created Index and Index Pattern and user is on that Page
    Then delete index and Index Pattern
   Then Delete FileBeat Directory
