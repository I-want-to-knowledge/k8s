package operate;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
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
        // 版本号 io.fabric8.kubernetes-client
        KubernetesClient client = new DefaultKubernetesClient();
        String namespace = "default";
        String podName = "programmatically-created-pod";


        // list pods in the default namespace
        PodList pods = client.pods().inNamespace(namespace).list();
        pods.getItems().forEach(s -> System.out.println("Found pod：" + s.getMetadata().getName()));

        // create a pod
        System.out.println("Create a pod");
        Pod pod = new PodBuilder()
                .withNewMetadata().withNamespace(namespace).withName(podName).endMetadata()
                .withNewSpec()
                .addNewContainer()
                .withName("main").withImage("busybox").withCommand(Arrays.asList("sleep", "99999"))
                .endContainer()
                .endSpec()
                .build();
        ObjectMeta metadata = pod.getMetadata();
        client.pods().inNamespace(metadata.getNamespace()).createOrReplace(pod);
        System.out.println("Create pod : " + pod);

        // edit the pod (add a label to it)
        client.pods().inNamespace(metadata.getNamespace()).withName(metadata.getName())
                .edit(pod1 -> new PodBuilder(pod1).editMetadata().addToLabels("foo", "bar").endMetadata().build());
        System.out.println("Added label foo=bar to pod");

        System.out.println("Waiting 1 minute before deleting pod...");
        Thread.sleep(60000);

        // delete the pod
        client.pods().inNamespace(metadata.getNamespace()).withName(metadata.getName()).delete();
        System.out.println("Deleted the pod");
    }
}
