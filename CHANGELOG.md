## 0.5.0b9 (2022-01-19)

### Feat

- make branching check message  disapear

### Perf

- add docker layer cache

## 0.5.0b8 (2022-01-19)

### Fix

- bad workflow env variable
- wrong docker base version

### Refactor

- improve mapping/updating & tests

## 0.5.0b7 (2022-01-17)

### Fix

- push semver commit to target branch

### Refactor

- spring version config

## 0.5.0b6 (2022-01-10)

### Refactor

- extract architectural tests

### Fix

- **ci**: wrong if condition

### Feat

- docker deployments (#61)

## 0.5.0b5 (2021-12-14)

### Feat

- **ci**: automatic client building and upload

## 0.5.0b4 (2021-12-14)

### Feat

- conditional client generation

## 0.5.0rc0 (2021-11-29)

### Fix

- release script

### Perf

- remove label after merge

## 0.5.0b3 (2021-11-29)

## 0.5.0b2 (2021-11-29)

### Fix

- no review on fisr commit
- ci not running on new PRs

## 0.5.0b1 (2021-11-29)

## 0.5.0b0 (2021-11-29)

### Feat

- docker support

### Perf

- reduce labeling

## 0.4.0 (2021-11-29)

## 0.4.0rc0 (2021-11-28)

### Fix

- sonar issues

## 0.4.0b2 (2021-11-28)

### Refactor

- make `test` execute all test types

### Feat

- update done status endpoint

## 0.4.0b1 (2021-11-28)

### Perf

- use unified gradle compile task
- enable build cache and parallelism

### Fix

- bad reference
- bad reference

## 0.4.0b0 (2021-11-28)

### Fix

- cz bump path
- adapt gradle for tests
- sonar issue
- old module paths in ci files

### Feat

- add API arch test
- add todo unit test
- add todo api
- add integration test
- add todo (example) backend
- add backend arch tests

### Refactor

- move arch tests
- restructure modules

### Perf

- only re-generate OAS when source changes

## 0.3.0 (2021-11-21)

### Fix

- bad tag format

## 0.3.0-rc0 (2021-11-20)

### Fix

- junit test version
- prerelease creation
- open api skipping

### Feat

- pre-release automation

## 0.3.0-b2 (2021-11-20)

### Perf

- prevent useless client build

## 0.3.0-b1 (2021-11-20)

### Fix

- labeling

## 0.3.0-b0 (2021-11-20)

### Fix

- dependabot being rejected
- allow 'main' and 'master'
- dependabot unable to merge

### Feat

- atutomerge master on release

## 0.2.0- (2021-11-18)

### Fix

- bad tagging

## 0.1.0- (2021-11-18)

### Fix

- reviewer file-format

## 0.1.0-rc0 (2021-11-18)

### Fix

- main branch not labeled
- disable pr-title-check for non feat branches

## 0.1.0-b0 (2021-11-18)

### Refactor

- stop using semver
- remove v from version tags
- releasing & merging
- stop comiting from build
- change check run condition
- replace oas-diff action
- rework workflow chain
- make intellij config more generic

### Fix

- pulling
- make cz semver compilant
- changelog generation
- bash if or
- output set
- git fetch ref-parse
- quoting
- typo
- file checker
- finalize stage
- invalid name
- typo
- permission & finalizing
- permission for gradlew file
- bash if or
- finalize problems
- finalize phase
- finalize
- message & fail condition
- missing pr number
- composit actions
- replace wrong uses
- remove bad command
- add missing use
- **security**: replace bash script with js
- composit action syntax
- usage of failure and success as variables
- wait for checks
- invalid title removal
- review condition
- breaking typo
- duplcate ids
- verify edits
- add debug stage
- stringcast :(
- review not starting
- fork condition
- run check
- merge behaviour
- label removal
- enable checks for `ready_for_review`
- label removal
- pre remove labeling
- make QA workflow appear in PR
- missing hotfix branch check
- PR pre-processing (#15)
- wrong conv-con regex


fix: regex check

For some reason bash doesnt likes it inline
fix: update file checker


fix: issue with external action


refactor: allow externals pr only to `dev`branch
- missing string literals
- typo preventing workflow
- branching-check
- string quotes
- if
- head and PR ref not resolved
- add run
- stupidity

### Perf

- fix skip not-needed steps
- reuse pre-built artifacts
- skip OAS task if api doesnt changes

### Feat

- add baseline clients
- ignore fork branch naming
- improve processing chain
- remove comment duplication
- **PR**: reviewing & merging (#19)
- add review & pr completion
- test long-therm branches
- add qs workflow (#16)
- add pr pre-processing
- branch checking action
- filter information
- add intelliJ support
- finalize diagrams
