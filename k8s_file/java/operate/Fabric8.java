package operate;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

import java.util.Arrays;

/**
 * java 对pod的正删改查
 *
 * @author YanZhen
 * @date 2021/12/01 09:15
 */
public class Fabric8 {
    public static void main(String[] args) throws InterruptedException {
        // 版本号 io.fabric8.kubernetes-client:4.13.3
//        KubernetesClient client = new DefaultKubernetesClient();
//
//        // list pods in the default namespace
//        PodList pods = client.pods().inNamespace("default").list();
//        pods.getItems().forEach(s -> System.out.println("Found pod：" + s.getMetadata().getName()));
//
//        // create a pod
//        System.out.println("Create a pod");
//        Pod pod = client.pods().inNamespace("default").createNew()
//                .withNewMetadata().withName("programmatically-created-pod").endMetadata()
//                .withNewSpec()
//                .addNewContainer().withName("main").withImage("busybox").withCommand(Arrays.asList("sleep", "99999")).endContainer()
//                .endSpec()
//                .done();
//        System.out.println("Create pod : " + pod);
//
//        // edit the pod (add a label to it)
//        client.pods().inNamespace("default").withName("programmatically-created-pod")
//                .edit().editMetadata().addToLabels("foo", "bar").endMetadata().done();
//        System.out.println("Added label foo=bar to pod");
//
//        System.out.println("Waiting 1 minute before deleting pod...");
//        Thread.sleep(60000);
//
//        // delete the pod
//        client.pods().inNamespace("default").withName("programmatically-created-pod").delete();
//        System.out.println("Deleted the pod");
    }
}
