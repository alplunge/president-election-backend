# President Election Service
by Alminas Plunge

# Requirements
Design and implement a simplified President Election application back-end

# Explicit requirements:
1. The code must be written in Java language.
2. You may use any frameworks you need, but try to add as little dependencies as
3. There are no specific requirements for data storage. You can keep data in memory.
Be prepared to discuss alternatives.
4. All interaction with an application must be implemented via REST endpoints. 
5. REST API Requests/Responses have to be simple and easy to read/understand.
6. Be mindful about naming and comments. Your code must be readable and clean.
7. Your final delivery must be a Maven project.

# Implementation details:

I used spring boot framework to power API. It is easy to use and reasonable fast: https://spring.io/projects/spring-boot

## User Stories:

1. Create data models of Candidate, Voter and Vote;
2. Implement java entities for Candidate, Voter and Vote data models;
3. Implement repositories for a java entities;
4. Implement service Candidate and Vote services;
5. Implement Region, Candidates and votes data transfer objects;
6. Implement Elections controller;  

## API Usage

### List all candidates

**Definition**

`GET election/candidates`

**Response**
- `200  OK` on success

```json
[
    {
        "fullName": "Uzumaki Naruto",
        "number": 1,
        "agenda": "An “ultra-millionaire tax” on people worth more than 50 million and a major overhaul of housing policies."
    },
    {
        "fullName": "Uchiha Itachi",
        "number": 2,
        "agenda": "Spend 1.7 trillion to set the Konoha on track to eliminate net greenhouse gas emissions by 2050."
    }
]
```

### Register a new vote

**Definition**
`POST election/votes`

**Arguments**

- `"candidateNumber":integer` a candidate's number on the list of the voted candidate
- `"voterSsn":integer` a voter's social security number 

**Response**
- `201 Created` on success 

If a vote has already been cast by the voter, then error message will be returned. 

- `401 Unauthorised` on trying to vote again

```json
A vote has already been cast by the voter 122211
```

- `404 Not Found` if the candidate does not exist

```json
Candidate does not exist 122
```

- `404 Not Found` if the voter is not registered

```json
Voter does not exist 234234
```

## Lookup of overall distribution of votes amongst candidates

**Definition**
`GET election/votes`

**Response**

- `200 OK` on success

```json
[
	{
        "candidate": {
            "fullName": "Uzumaki Naruto",
            "number": 1,
            "agenda": "An “ultra-millionaire tax” on people worth more than 50 million and a major overhaul of housing policies."
        },
        "numberOfVotes": 3
    },
    {
        "candidate": {
            "fullName": "Uchiha Itachi",
            "number": 2,
            "agenda": "Spend 1.7 trillion to set the Konoha on track to eliminate net greenhouse gas emissions by 2050."
        },
        "numberOfVotes": 0
    }
]
```

## Lookup of voting result distribution amongst different regions

**Definition**
`GET election/regions`

**Response**

- `200 OK` on success

```json
[
    {
        "region": "Mid-Atlantic",
        "votes": [
            {
                "candidate": {
                    "fullName": "Shikadai Nara",
                    "number": 6,
                    "agenda": "Sand will be free!"
                },
                "numberOfVotes": 1
            }
        ]
    },
    {
        "region": "New England",
        "votes": [
            {
                "candidate": {
                    "fullName": "Uzumaki Naruto",
                    "number": 1,
                    "agenda": "An “ultra-millionaire tax” on people worth more than 50 million and a major overhaul of housing policies."
                },
                "numberOfVotes": 1
            }
        ]
    }	
		
]
```
## Return a winner cadidate

**Definition**
`GET election/winner`

**Response**

- `200 OK` on success when candidates been voted for by more than 50%

```json
[
    {
        "fullName": "Uzumaki Naruto",
        "number": 1,
        "agenda": "An “ultra-millionaire tax” on people worth more than 50 million and a major overhaul of housing policies."
    }
]
```
- `200 OK` on success when there is no one winner candidate

```json
[
    {
        "fullName": "Uzumaki Naruto",
        "number": 1,
        "agenda": "An “ultra-millionaire tax” on people worth more than 50 million and a major overhaul of housing policies."
    },
    {
        "fullName": "Uchiha Itachi",
        "number": 2,
        "agenda": "Spend 1.7 trillion to set the Konoha on track to eliminate net greenhouse gas emissions by 2050."
    }

]
```
- `404 Not Found` when there are more than two candidates with the same votes

```json
To many participants (3) have the same amount of votes. No clear winner.
``` 
