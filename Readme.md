# demoプログラム説明

### 環境
* OS : Windows 10 Pro
* JDK : Adopt OpenJDK 15.0.1.9
* Build Tool : Gradle 6.7.1
* DBMS : Apache Derby 10.14.2.0

※ JDK/Build Tool/DBMSのbinをOS環境変数のPATHに追加

### Derby設定
* インストール先 : C:\\derby-10.14.2.0
* derby設定ファイル : C:\\derby-10.14.2.0\\bin\\derby.properties
* データ格納先 : C:\\derby-10.14.2.0\\dat
* データベース名 : test

### ソースコード保存先
* https://github.com/okennyjp/demo

### ビルド
* 展開先 : 任意(開発は C:\\workspace\\demo で実行)
* ビルド : コマンドプロンプトで展開先に移動して gradle build を実行

### テーブル作成
* DDL保存先 : C:\\workspace\\demo\\derby\\script
* データベース作成 : コマンドプロンプトでDDL保存先に移動して ij database-create.sql を実行
* テーブル作成 : コマンドプロンプトでDDL保存先に移動して ij users-create.sql を実行
* サンプル登録 : コマンドプロンプトでDDL保存先に移動して ij users-insert.sql を実行

### 実行
* 実行 : コマンドプロンプトで展開先に移動して gradle bootrun を実行
* エントリポイント : http://localhost:8080/sign-on
