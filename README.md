# kanbagisi

PROJE HENÜZ BİTMEMİŞTİR. (%60 aşamasındadır.)
Geliştirmek isteyenler geliştirip güncelleyebilir.

***Özet*** 
*JSF,PrimeFaces,JPA ile Kan Bağış Uygulaması yapılması *

####  **Giriş** 
Uygulama 'nın anasayfası'nda bir login formu ve Kan arama butonu bulunmaktadır. Üye Olanlar için içeride bilgi ekleme,güncelleme ve silme işlemleri yapılacaktır. Arama Bölümünde şehir ve kan grubu bilgilerini girerek kendilerine en yakın bağışçıları bulacaklardır.

####  **Sistemler ve Temel Çalışma Prensibi** 
>- Login formunda girişi başarılı yapmadığı sürece kullanıcı paneline giriş yapılamaz. 
>- Kayıt Ol butonuna basıldığında kullanıcı adı ve şifre girerek yeni üyelik açılabilmektedir
>- Kullanıcı başarılı bir şekilde giriş yaptıktan sonra bilgi ekleyebilir ve var olan bilgilerini güncelleyebilir ve silebilir. 
>- Arama formunda gerekli bilgileri girdiği taktirde bağışçıları görebilmektedir.
>-Çıkı butonu ile anasayfaya geri dönebilmektedir.

#### **Teknik Seçimler**
Uygulamada **JSF**,**JPA**,**PRIMEFACES**,**HTML 5**,**CSS** ve **Apache Tomcat Server** sistemleri kullanılmıştır. 
> **JSF** Uygulamadaki ön yüz için kullanılmıştır. **PRIMEFACES** ile kullanımda oldukça pratik ve kullanışlıdır. 
> **JPA** kullanarak Sql zahmetinden ve kargaşasından kurtularak düzenli bir şekilde sorgu yapabildim.JPA nesnelerin ilişkilendirilmesini sağlıyor ve sql ile bağlantılarımı class'lar üzerinden gerçekleştirebidim.
> **APACHE TOMCAT SERVER** 'ı tercih ettim. Benim için daha kullanışlı ve ilk proje tecrübem olduğu için gelen önerileri dikkate aldım.
>IDE olarak NetBeans kullandım çünkü Java EE ve Java ile web application geliştirmek hakkında daha önce bir bilgim ve tecrübem yoktu. Hem daha hızlı kullanmak hem de zamanım kısıtlı olduğu için NetBeans i tercih ettim.

#### <i class="icon-wrench"></i> **Kurulum ve Sistem Gereksinimleri**
>Apache Tomcat Server ile Kurulum.
> - Sistemimizde Apache Tomcat Server olması gerekmektedir. Ayrıca catalina.bat dosyası tanımlanmalıdır.
> - Apache Tomcat Server başlatılır ve login ekranına(anasayfa) giriş yapılır.(Default olarak 8080 portunu kullanarak yönetini paneline giriş yapabiliriz. http://localhost:8080 )
> Proje'yi Netbeans'de açmanız gerekmektedir.
> -  Projeyi yükleme işleminden sonra projenin veritabanı belgesini yüklememiz gerekmektedir.  (Bunun için phpmyadmin veya mysql workbench,navicat kullanabiliriz.)
> - tutorial adında bir Database (karşılaştırma kısmı utf8_turkish_ci)  oluşturup  içerisine  mysql.sql dosyasını import ediyoruz. 

*Uygulama Yunus Emre Demir (yemredemir817@gmail.com ) tarafından yazılmıştır.
