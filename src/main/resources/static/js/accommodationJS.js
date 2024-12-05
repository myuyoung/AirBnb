document.addEventListener('DOMContentLoaded', async function () {
    //URL에서 id값을 추출하기
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');

        try{
        const response = await fetch(`/api/accommodations/detail?id=${id}`);
        const accommodation = await response.json();
        if(!response.ok){
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        // 네이버 지도 초기화
        const map = new naver.maps.Map('map', {
            center: new naver.maps.LatLng(accommodation.latitude, accommodation.longitude),
            zoom: 15
        });

        // 마커 추가
        new naver.maps.Marker({
            position: new naver.maps.LatLng(accommodation.latitude, accommodation.longitude),
            map: map,
            title: accommodation.name
        });
    } catch(error){
        console.error('Failed to fetch accommodation data', error);
    }
});
