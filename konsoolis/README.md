# Objektorienteeritud programmeerimise esimene rühmatöö
# Memoriin


**Autorid**: Lee Saarela, Maarek Vettik

**Projekti eesmärk:** Programmeerida memoriin, millega saab mälu treenida ja õppida maatriksi koordinaatsüsteemi, nii nagu seda kasutatakse erinevates programmeerimiskeeltes.

**Programmi töökäik**

Mängu alguses kuvatakse kasutajale mängu juhised.   
	"Memoriin.  
       	Leia mängulaualt võimalikult kiiresti sümbolite paarid.  
	Mäng lõppeb, kui kõik paarid on leitud või "lõpp" sisestamisel.  
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
1. Kuvatakse kasutajale “#”-märkidest moodustatud mängulaua hetkeseis ning palutakse sisestada elementide koordinaadid, mille väärtusi kasutaja soovib näha. Samuti salvestatakse esimesel korral klassi Tulemused mängu algusaeg.
2. Kasuja sisestatud koordinaatide korrektsust kontrollitakse klassis KoordinaadiKontrollija ehk kas sisestatud koordinaatidega element on mängulaua mõõtmetes, kas see on veel mängulaual alles ja ega sama elemendi koordinaate ei sisaldatud topelt.
3. Kuvatakse kasutajale mängulaud, kus soovitud koordinaatidel olevaid elementide väärtusi on näha.  
Kui kasutaja leidis kaks samasugust elementi, asendatakse need kuvatavas maatriksis alakriipsudega ning salvestatakse mängulaua hetkeseis. Vastasel juhul mängulauda ei muudeta ja tegevust korratakse.

**Klasside jaotus**
1. Peaklass - mängu põhiosa
2. MängulauaKoostaja - genereerib mängu alguses mänguvälja ja sinna suvalised tähed
3. MängulauaKontrollija - kontrollib, kas sisestatud mängulaual on paaris arv elemente
4. MängulauaMuutja - salvestab mängu seisu ja kuvab tulemuse kasutajale
5. KoordinaadiKontrollija - kontrollib, kas sisestatud koordinaadid on antud mängu seisus relevantsed
6. Tulemused - salvestab tulemused nii, et need saaks mängu lõpus väljastada


**Töö protsess**
1. Idee välja töötamine
2. Ülesannete jaotamine
3. Projekti kirjelduse koostamine
4. Klasside programmeerimine
5. Testimine ja silumine

**Rühmaliikmete panused**

Lee: Projektikirjelduse kirjutaine, klassid Peaklass, Mängulaud ja KoordinaadiKontrollija (maatriksi piiride kontroll)

Maarek: Githubi üles seadmine ja failistruktuur, klassid MängulauaKontrollija, Tulemused, MängulauaKoostaja ja ülejäänud osa KoordinaadiKontrollijast.

**Murekohad**
Giti kasutamine.

**Hinnang**
Arvame, et töö läks üldiselt hästi. Mäng toimib sujuvalt ning struktuur pole väga keeruline. Mõnes kohas võib veel erindeid tekkida, kui kasutaja ei sisesta korrektseid andmeid. Kuna juhendis oli kirjas, et võime eeldada korrektseid sisendeid, siis ei pandud sellele täielikku rõhku. Muidu võiks erinevaid sisendeid rangemalt kontrollida ning kuvada kasutajale ekraanil, mis täpselt valesti läks.

**Testimine**
Näiteks tegime ajutise koodi, mis loob mänguvälja ja täidab selle ainult samade sümbolitega. Nii oli kiirem kontrollida erinevaid funktsioone, mis olid seotud sarnasuse kontrolliga. Lisaks sai alati luua näiteks 2x2 mõõdus mänguvälja, mida on lihtsam kiiresti kontrollida. 
