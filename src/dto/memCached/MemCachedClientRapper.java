package dto.memCached;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * MemCachedClientのラッパークラス。<br>
 * 初期設定を行い、複数のMemCachedClientインスタンスを作成させないために作成した。
 * @author akitani
 *
 */
public class MemCachedClientRapper{
	private static MemCachedClient memCachedClient = new MemCachedClient();

	static{
		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(new String[]{"localhost:11211"});
		pool.initialize();
	}

	private MemCachedClientRapper(){
	}

    public static boolean set(String s, Object obj){
        return memCachedClient.set(s, obj);
    }

	public static boolean set(String s, Object obj, Date date){
		return memCachedClient.set(s, obj, date);
	}

	public static Object get(String s){
		return memCachedClient.get(s);
	}
}
