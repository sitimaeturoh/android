<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
		$kodeminimarket = $_POST['kodeminimarket'];
		$namaminimarket = $_POST['namaminimarket'];
		$kategori = $_POST['kategori'];
		
		
		if($kodeminimarket == '' || $namaminimarket == '' || $kategori == '' ){
			echo 'Mohon datanya dilengkapi terlebih dahulu!';
		}else{
			require_once('connection.php');
			$sql = "SELECT * FROM tb_kuis WHERE kodeminimarket='$kodeminimarket'";
			
			$check = mysqli_fetch_array(mysqli_query($con,$sql));
			
			if(isset($check)){
				echo 'Nama produk sudah ada';
			}else{				
				$sql = "INSERT INTO tb_kuis (kodeminimarket, namaminimarket, kategori) VALUES('$kodeminimarket','$namaminimarket','$kategori')";
				if(mysqli_query($con,$sql)){
					echo 'Data berhasil diinput';
				}else{
					echo 'oops! Mohon coba lagi!';
				}
			}
			mysqli_close($con);
		}
}else{
echo 'error';
}