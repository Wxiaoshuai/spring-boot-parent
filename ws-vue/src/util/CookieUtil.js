// 设置cookie
export function setCookie(key, value) {
  console.log('set cookie')
  let ex_date = new Date();
  ex_date.setTime(ex_date.getTime() + 24 * 60 * 60 * 1000) //保存 7 天
  window.document.cookie = key + '=' + value + ';path=/;expires=' + ex_date.toUTCString()
}

// 读取cookie
export function getCookie(param) {
  let c_param = ''
  if (document.cookie.length > 0) {
    let arr = document.cookie.split(';')
    for (let i = 0; i < arr.length; i++) {
      let arr2 = arr[i].split('=')
      if (arr2[0] == param) {
        c_param = arr2[1];
      }
    }
    return c_param
  }
}
