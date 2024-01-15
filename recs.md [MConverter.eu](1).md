REQUIREMENT SPECIFICATIONS

Reviewer module

### 1. Reviewer Login Page

#### 1.1 Purpose

The purpose of the Reviewer Login Page is to authenticate and authorize
reviewers to access the conference system.

#### 1.2 Scope

The Reviewer Login Page will provide a secure login mechanism for
reviewers, allowing them to access the system using either traditional
credentials or social login methods.

#### 1.3 Requirements

##### Authentication and login:

Implement a system to allow a user to register himself/herself as a
reviewer using their email ID and can additionally provide a mobile
number at his/her discretion.

##### Account recovery:

Implement a mechanism via which a reviewer can reset the password in
case they forget. They can reset their password via OTP sent to their
mail or mobile number(if provided).

##### Authorization

Prevent users who are not listed as reviewers in the database from
logging in to the reviewer portal.

##### Login Restrictions

Reviewers using social login methods shall only be allowed access if
their credentials match an entry in the list of approved reviewers.

##### Account Lockout

The system shall implement an account lockout mechanism after a
specified number of unsuccessful login attempts to enhance security.

### 2. Reviewer Dashboard

#### 2.1 Purpose

The purpose of the Reviewer Dashboard is to provide reviewers with a
central hub to manage their reviewing tasks efficiently.

#### 2.2 Scope

The Reviewer Dashboard will display a list of papers assigned to the
reviewer for review, facilitating easy navigation and submission of
evaluations.

#### 2.3 Requirements

##### Paper List

The system shall present a clear and organized list of papers assigned
to the reviewer on their dashboard. The papers will be categorized as
reviewed or pending and each of these categories will be organized by
their respective authors.

##### Edit/Delete review

If a reviewer wants to edit a review, the status of the review will be
changed from reviewed to pending and the user can either update the
review by editing the rating/review/comments and resubmit(after which
the status will be changed back to reviewed) or delete the review
entirely.

##### Paper Details

For each paper in the list, the system shall display relevant details
such as title, abstract, author information, and submission status.

##### Reviewer Actions

The reviewer shall be able to access actions for each paper, including
submitting reviews, viewing paper details, and providing feedback via
comments. The reviewer will also provide a numerical rating on a scale
of 1-5 as a final and succint verdict. The review and rating are
mandatory to mark a paper as reviewed.

##### Task Status

The system shall indicate the status of the reviewer's tasks, including
pending reviews, completed reviews, and upcoming deadlines.

##### Notification

The system shall notify reviewers of new assignments, approaching
deadlines, and any important updates related to their reviewing tasks.
The notifications will be sent to their registered mail-id.

##### Log out Functionality

The dashboard will have a button for the user to logout of the reviewer
portal.

### 3. Non-functional Requirements

#### 3.1 Security

The Reviewer Login Page and Dashboard shall adhere to best possible
practices for security, including encryption of sensitive data(in this
case, sensitive data only include the login credentials).

#### 3.3 Compatibility

The Reviewer Module shall be compatible with common web browsers and
devices, ensuring accessibility for all reviewers.

#####  3.4 User Interface

The Reviewer Dashboard shall have an intuitive and user-friendly
interface, promoting ease of use and navigation. Since the numbers of
features to be implemented are few, it is assumed that adhering to the
specifications of this document will ensure a user-friendly experience
by default.

<span id="anchor"></span><img src="Pictures/1000000100000E3600000B96692D76F9DE0602C5.png"
style="width:17cm;height:13.859cm" />
