import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val mutableNumAttempts = MutableLiveData<String>()
    val numAttempts: LiveData<String> get() = mutableNumAttempts

    fun setNumAttempts(attempts: String){
        mutableNumAttempts.value = attempts
    }

    fun getNumAttempts(): String{
        return numAttempts.toString()
    }

    fun reset(){
        mutableNumAttempts.value = "Number of attempts: 0"
    }
}