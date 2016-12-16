/**
 * Created by 91574 on 2016/12/15.
 */

function passwordSame(p1,p2) {
    var same=document.getElementById("unlike");
    if (p1==p2)
        same.style.display="none";
    else
        same.style.display="block";
}