<?php
require_once 'koneksi.php';
if($_SERVER['REQUEST_METHOD'] == 'POST')
{
$kodeminimarket = $_POST['kodeminimarket'];
$namaminimarket = $_POST['namaminimarket'];
$kategori = $_POST['kategori'];
$query = "INSERT INTO tb_kuis (kodeminimarket, namaminimarket, kategori) VALUES
('$kodeminimarket','$namaminimarket','$kategori')";
$exeQuery = mysqli_query($konek, $query);
echo ($exeQuery) ? json_encode(array('kode' =>1, 'pesan' => 'berhasil menambahkan data'))
: json_encode(array('kode' =>2, 'pesan' => 'data gagal ditambahkan'));
}
else
{
echo json_encode(array('kode' =>101, 'pesan' => 'request tidak valid'));
}
?>
