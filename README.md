# Objektorienteeritud programmeerimise esimene rühmatöö
# Memoriin


**Autorid**: Lee Saarela, Maarek Vettik

**Projekti eesmärk:** Programmeerida memoriin, millega saab mälu treenida ja õppida maatriksi koordinaatsüsteemi, nii nagu seda kasutatakse erinevates programmeerimiskeeltes.

**Programmi töökäik**

Mängu alguses kuvatakse kasutajale mängu juhised. 
	"Memoriin.
       	Leia mängulaualt võimalikult kiiresti sümbolite paarid.
	Mäng lõppeb, kui kõik paarid on leitud või "lp" sisestamisel.
	Pane tähele! Mängulaual laiusega m ja pikkusega n arvestatakse elementide koordinaate järgnevalt:
		(0,0) (0,1) … (0,m)
		(1,0) (1,1) … (1,m)
		…     …    …   …
		(n,0) (n,1) … (n,m)”

Seejärel palutakse kasutajal sisestada soovitud mängulaua pikkus, laius ning valida kas mägulaud on raksema või kergema tasemega. Seda, et mängulaual oleks paaris arv elemente kontrollib klass MängulauaKontrollija. Kui sisestatud mängulaud vastab vajalikele tingimustele genereeritakse klassi MänguväljaKoostaja abil suvaliste sümbolitega (s) mängulaud, kus iga täht esineb täpselt kaks korda. 
Näiteks sisendi 4, 5 korral moodustatakse mängulaud 
sssss
sssss
sssss
sssss

Kuni kasutaja ei ole leidnud üles kõiki paare või sisestanud lõpumärguannet, korratakse järgnevaid tegevusi ja logitakse neid klassis Tulemused:
Kuvatakse kasutajale “#” moodustatud mängulaua hetkeseis ning lastakse sisestada elementide koordinaadid, mille väärtusi kasutaja soovib näha. Samuti salvestatakse klassi Tulemused mängu algusaeg.
Eelneva näite põhjal on mängulaud
#####
#####
#####
#####
ja kasutaja sisestas koordinaadid 0,3 ning 3,4.
Kuvatakse kasutajale mängulaud, kus soovitud koordinaatidel olevaid elementide väärtusi on näha.
Kui kasutaja leidis kaks samasugust elementi, asendatakse need kuvatavas maatriksis tühikutega ning salvestatakse mängulaua hetkeseis.
Vastasel juhul midagi ei muutu ja tegevust korratakse.

1. Peaklass - mängu põhiosa
2. MängulauaKoostaja - genereerib mängu alguses välja ja sinna suvalised tähed
3. MängulauaKontrollija - kontrollib kas sisestatud mängulaual on paaris arv elemente
4. MängulauaMuutja - salvestab mängu seisu ja kuvab tulemuse kasutajale
5. KoordinaadiKontrollija - kontrollib kas sisestatud koordinaadid on antud mängu seisus relevantsed
6. Tulemused - salvestab tulemused nii, et need saaks lõpus väljastada


**Töö protsess**
1. Idee välja mõtlemine
2. Ülesannete jaotamine
3. Projekti kirjelduse kirjutamine
4. Klasside programmeerimine
5. Vigadeparandus

**Rühmaliikmete panused**

Lee: Projektikirjelduse kirjutaine, klassid Peaklass, Mängulaud ja KoordinaadiKontrollija (see osa, mis kontrollib, et sisestatud koordinaadid oleksid maatriksi mõõtmetes)

Maarek: Githubi üles seadmine ja failistruktuur, klassid MängulauaKontrollija, Tulemused, MängulauaKoostaja ja ülejäänud osa KoordinaadiKontrollijast.

**Murekohad**



