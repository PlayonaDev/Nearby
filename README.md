# Nearby: Introdução

O Nearby é um aplicativo Android desenvolvido com Kotlin e Jetpack Compose que oferece uma experiência de exploração local. Ele permite que os usuários descubram categorias como Alimentação, Cinema, Compras, Padaria e Hospedagem. O app também exibe locais selecionados em um mapa com plotagem, apresenta cards interativos com detalhes sobre os estabelecimentos e funcionalidades como:

- **Splash Screen**: Tela inicial que exibe o logotipo do app.

* **Tela de boas-vindas**: Explicação de como o aplicativo funciona.

+ **Exploração por categorias**: Exibe listas de categorias e os estabelecimentos associados.

- **Detalhes de estabelecimentos**: Apresenta informações detalhadas, cupons disponíveis, regras de uso de cupons e um botão para leitura de QR Code.

+ **Utilização de cupons**: Ao ler o QR Code de um estabelecimento, um cupom é validado.

---

## Passos de Configuração


### 1. Ajustar o arquivo `AndroidManifest.xml`
Certifique-se de incluir sua chave da API do Google Maps no arquivo `AndroidManifest.xml`. Substitua a linha correspondente por sua própria chave, gerada no Google Cloud Platform (GCP):

```xml
<?xml version="1.0" encoding="utf-8"?>

<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <uses-permission android:name="android.permission.INTERNET" />

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:networkSecurityConfig="@xml/network_security_config"
        android:icon="@mipmap/ic_nearby_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_nearby_launcher_round"
        android:supportsRtl="true"
        android:usesCleartextTraffic="true"
        android:theme="@style/Theme.Nearby"
        tools:targetApi="31">
        <activity
            android:name="com.example.nearby.MainActivity"
            android:exported="true"
            android:theme="@style/Theme.Nearby">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <meta-data
            android:name="preloaded_fonts"
            android:resource="@array/preloaded_fonts" />
        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="SUA_CHAVE_GCP_AQUI" />
    </application>

</manifest>
```
> [!NOTE]
> Você deve criar a chave da API no console do GCP e habilitar o serviço Google Maps para utilizá-la.

### 2. Configurar o `NearbyRemoteDataSource`
O arquivo `NearbyRemoteDataSource` é responsável por consumir os dados do backend. Ele permite configurar URLs diferentes para rodar o aplicativo em um celular físico ou no emulador. Utilize o código abaixo como referência:

```kotlin
package com.example.nearby.core.network

import com.example.nearby.core.network.KtorHttpClient.httpClientAndroid
import com.example.nearby.data.model.Category
import com.example.nearby.data.model.Coupon
import com.example.nearby.data.model.Market
import com.example.nearby.data.model.MarketDetails
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object NearbyRemoteDataSource {

    private const val LOCAL_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333" // Para emulador
    private const val LOCAL_HOST_DEVICE_BASE_URL = "http://192.168.0.xxx:3333" // Substitua pelo seu IP local para celular físico
    private const val BASE_URL = LOCAL_HOST_EMULATOR_BASE_URL

    suspend fun getCategories(): Result<List<Category>> = try {
        val categories = httpClientAndroid.get("$BASE_URL/categories").body<List<Category>>()
        Result.success(categories)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarkets(categoryId: String): Result<List<Market>> = try {
        val market = httpClientAndroid.get("$BASE_URL/markets/category/${categoryId}")
            .body<List<Market>>()
        Result.success(market)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarketDetails(marketId: String): Result<MarketDetails> = try {
        val market = httpClientAndroid.get("$BASE_URL/markets/${marketId}")
            .body<MarketDetails>()
        Result.success(market)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun patchCoupon(marketId: String): Result<Coupon> = try {
        val coupon = httpClientAndroid.patch("$BASE_URL/coupons/${marketId}").body<Coupon>()
        Result.success(coupon)
    } catch (e: Exception) {
        Result.failure(e)
    }
}
```
> [!NOTE]
> Substitua o IP local no `LOCAL_HOST_DEVICE_BASE_URL` pelo IP da sua máquina para testar no celular físico.

---

### 3. Criar o arquivo `network_security_config.xml`
Este arquivo é necessário para permitir conexões em texto claro com o backend (HTTP). Adicione o seguinte arquivo na pasta `res/xml` do seu projeto:

```xml
<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <domain-config cleartextTrafficPermitted="true">
        <domain includeSubdomains="true">192.168.0.xxx</domain> <!-- Substitua pelo seu IP local -->
        <domain includeSubdomains="true">10.0.2.2</domain> <!-- Para emulador -->
    </domain-config>
</network-security-config>
```
>[!IMPORTANT]
>Substitua `192.168.0.xxx` pelo IP local do seu computador.

Certifique-se de referenciar esse arquivo no `AndroidManifest.xml`:

```xml
<application
    android:networkSecurityConfig="@xml/network_security_config"
    ...>
```

---

### 4. Backend: `nlw-pocket-mobile-api-main`
Este projeto consome dados de um backend chamado `nlw-pocket-mobile-api-main`. Certifique-se de ter o backend configurado e rodando na mesma rede local para realizar testes.

Clone o repositório do backend e execute-o:

```bash
git clone https://github.com/seuusuario/nlw-pocket-mobile-api-main.git
cd nlw-pocket-mobile-api-main
npm install
npm start
```

---

### Conclusão
Com os passos acima, você estará pronto para rodar o aplicativo Nearby em um emulador ou dispositivo físico. Caso tenha dúvidas, sinta-se à vontade para pedir ajuda!

