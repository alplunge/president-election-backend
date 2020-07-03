INSERT INTO candidates (number, first_name, last_name, agenda) VALUES
  (1, 'Uzumaki', 'Naruto', 'An “ultra-millionaire tax” on people worth more than 50 million and a major overhaul of housing policies.'),
  (2, 'Uchiha', 'Itachi', 'Spend 1.7 trillion to set the Konoha on track to eliminate net greenhouse gas emissions by 2050.'),
  (3, 'Kakashi', 'Hatake', 'Undocumented immigrants with no criminal records “should not be the focus of deportation”. '),
  (4, 'Kabuto', 'Yakushi', 'A 1,000 a month universal basic income for every Konoha adult.'),
  (5, 'Zabuza', 'Momochi', 'Will push to ban so-called assault weapons if elected.'),
  (6, 'Shikadai', 'Nara', 'Sand will be free!');

INSERT INTO voters (ssn, region) VALUES
  (131, 'NEW_ENGLAND'),
  (122, 'THE_SOUTH'),
  (123, 'THE_SOUTH'),
  (143, 'THE_WEST'),
  (454, 'MID_ATLANTIC'),
  (235, 'NEW_ENGLAND'),
  (656, 'THE_SOUTH');

 INSERT INTO votes (ballot_Id, created_on, issue, candidate_number, voter_ssn) VALUES
  (1, '2008-01-01 00:00:01', 'PRESIDENT', 1, 131),
  (12, '2008-01-01 00:00:01', 'PRESIDENT', 1, 122),
  (14, '2008-01-01 00:00:01', 'PRESIDENT', 3, 143),
  (15, '2008-01-01 00:00:01', 'PRESIDENT', 1, 123),
  (45, '2008-01-01 00:00:01', 'PRESIDENT', 6, 454);
