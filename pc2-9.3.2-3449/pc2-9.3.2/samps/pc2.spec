Version: 9.3.2
Release: 3449
Summary: PC^2
Name: pc2
License: GPL
Group: Applications/Multimedia
URL: http://pc2.ecs.csus.edu

Source: http://pc2.ecs.csus.edu/code/v9/%{name}-%{version}-%{release}.tar.gz
BuildRoot: %{_tmppath}/%{name}-%{version}-%{release}-root

Packager: boudreat

%description
PC2 (the Programming Contest Control system, pronounced "P-C-squared"
or sometimes just "P-C-Two" for short) is a software system designed
to support programming contest operations in a variety of computing
environments. PC2 allows contestants (teams) to submit programs over
a network to contest judges. The judges can recompile the submitted
program, execute it, view the source code and/or execution results,
and send a response back to the team. The system also supports an
"automated judging" mode where judging is performed by software
rather than by human judges.

The system automatically timestamps and archives submitted runs,
maintains and displays current contest standings in a variety of
ways, and allows the judges to retrieve and reexecute archived
runs. It also provides a mechanism for contestants to submit
clarification requests and queries to the judges, and for the
judges to reply to queries and to issue broadcast bulletins to
teams. In addition, PC2 supports contests being held simultaneously
at multiple sites by automatically transmitting contest standing
information between sites and generating a single contest-wide
standings scoreboard at each remote site.

A wide variety of configurable options allow the contest
administrator to tailor the system to specific contest
operations. For example, the number of teams, problems, and languages
in the contest; the scoring method being applied; which problems are
handled by which judges; whether teams are automatically notified of
the result of a submission; and the frequency of automatic scoreboard
updates are all configurable. There are also mechanisms provided
for editing the internal scoring database, and for recovering
from various types of soft and hard errors. The system is designed
to allow teams to use any language development tool which can be
invoked from a command line and generates an executable file.

PC2 was developed at California State University,
Sacramento (CSUS), and is available on the World Wide Web at
http://pc2.ecs.csus.edu/.

The most recent version, V9, is written in Java (using Eclipse)
and is intended to run on any Java 1.7 (or greater) platform,
including Windows XP (or greater, ex Vista, 7, 8, 8.1, 10), 
Mac OS X (10.4+) and a variety of Unix-based systems including
Solaris, Linux, and FreeBSD.

%prep
%setup -q


%install
%{__rm} -rf %{buildroot}
# just move it into place
install -p -v -d %{buildroot}/usr/pc2
cp -p -r * %{buildroot}/usr/pc2

%clean
%{__rm} -rf %{buildroot}

%files
%defattr(-, root, root, 0755)
%doc /usr/pc2/README
%doc /usr/pc2/VERSION
%doc /usr/pc2/doc
%config /usr/pc2/pc2v9.ini
%config /usr/pc2/data
/usr/pc2/pc2.ico
# and the directories
/usr/pc2/bin
/usr/pc2/lib
/usr/pc2/samps

%changelog
* Tue Nov 24 2015 - boudreat AatT ecs DdOoTt csus DdOoTt edu
- Initial release.

