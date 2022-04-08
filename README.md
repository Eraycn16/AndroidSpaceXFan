[![](https://img.shields.io/badge/-Firebase-yellow)](https://firebase.google.com/)
[![](https://img.shields.io/badge/2.9.0-Retrofit-brightgreen)](https://square.github.io/retrofit/)
[![](https://img.shields.io/badge/4.12-Glide-brightgreen)](https://github.com/bumptech/glide)


# AndroidSpaceXFan Uygulaması

Bu uygulama Retrofit kütüphanesi kullanılarak SpaceX'in roket verilerini, yaklaşan lansman verilerini ve şirket hakkında bilgileri servis yardımıyla çekerek oluştrulan bir mobil uygulamadır. 

 |🧑 Kullanıcı Adı  | 🔒 Şifre |
| ------------- | ------------- |
| demo@eray.com | 123456  |

# Uygulama Giriş ve Kayıt Sayfası

<a href="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/1.png" target="_blank">
<img src="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/1.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/2.png" target="_blank">
<img src="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/2.png" width="200" style="max-width:100%;"></a>

 Uygulamaya giriş işlemi ve kayıt işlemleri için "Firebase Authentication" kullanılmıştır. Uygulamayı kullanabilmek için kayıt işlemi zorunlu kılınmıştır.
 
 # Uygulama İçeriği
 
 <a href="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/3.png" target="_blank">
<img src="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/3.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/4.png" target="_blank">
<img src="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/4.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/5.png" target="_blank">
<img src="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/5.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/6.png" target="_blank">
<img src="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/6.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/7.png" target="_blank">
<img src="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/7.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/8.png" target="_blank">
<img src="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/8.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/9.png" target="_blank">
<img src="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/9.png" width="200" style="max-width:100%;"></a>

<a href="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/10.png" target="_blank">
<img src="https://github.com/Eraycn16/AndroidSpaceXFan/blob/main/images/10.png" width="200" style="max-width:100%;"></a>

 Servisle çekilen roket verileri itemler şeklinde sıralanarak kullanıcıya sunulmaktadır. Kullanıcı herhangi bir roket itemine tıklayarak "Roket Detay Sayfasına" ilerler. Bir roketi favoriye ekleme ve favorilerden kaldırma işlemleri roket detayı alanından yapılmaktadır.Kullanıcı bir itemi favorilere ekleme işlemini yaptığı zaman bu veri "Firebase Realtime Database" e kaydedilir ve Firebase üzerinden kontrolü yapılarak bir itemin favorilere eklenip eklenmemiş olduğunun kontrolü yapılır. "Favoriler" alanında yer alan roket itemlerine tıklanıldığı zaman da "Roket Detay Sayfasına" ilerlenmektedir. "Yaklaşan Lansmanlar" alanında da çekilen veriler itemlere dönüştürülerek kullanıcıya sunulmuştur. Her bir itemin detay sayfası bulunmaktadır. 
